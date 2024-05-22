import Fluent
import Vapor
import Leaf

struct ProductController: RouteCollection {
    func boot(routes: RoutesBuilder) throws {
        let products = routes.grouped("products")

        products.get(use: { try await self.getAllHandler(req: $0) })
        products.post(use: { try await self.createHandler(req: $0) })
        products.group(":productID") { product in
            product.get(use: { try await self.getHandler(req: $0) })
            product.put(use: { try await self.putHandler(req: $0) })
            product.delete(use: { try await self.deleteHandler(req: $0) })
        }

        routes.get("view-products", use: self.productsViewHandler)
        routes.get("add-products", use: self.addProductViewHandler)
        routes.get("delete-products", use: self.deleteProductViewHandler)
    }
        
    func getAllHandler(req: Request) async throws -> [ProductDTO] {
        try await Product.query(on: req.db).all().map { $0.toDTO() }
    }

    func createHandler(req: Request) async throws -> ProductDTO {
        let product = try req.content.decode(ProductDTO.self).toModel()

        try await product.save(on: req.db)
        return product.toDTO()
    }

    func getHandler(req: Request) async throws -> ProductDTO {
        guard let product = try await Product.find(req.parameters.get("productID"), on: req.db) else {
            throw Abort(.notFound)
        }

        return product.toDTO()
    }

    func putHandler(req: Request) async throws -> HTTPStatus {
        guard let product = try await Product.find(req.parameters.get("productID"), on: req.db) else {
            throw Abort(.notFound)
        }

        let newProduct = try req.content.decode(ProductDTO.self)

        product.name = newProduct.name!
        product.description = newProduct.description!
        product.price = newProduct.price!
        
        try await product.update(on: req.db)
        return .noContent
    }

    func deleteHandler(req: Request) async throws -> HTTPStatus {
        guard let product = try await Product.find(req.parameters.get("productID"), on: req.db) else {
            throw Abort(.notFound)
        }

        try await product.delete(on: req.db)
        return .noContent
    }

    func productsViewHandler(req: Request) async throws -> View {
        let products = try await Product.query(on: req.db).all()
        let productDTOs = products.map { $0.toDTO() }
        return try await req.view.render("products", ["products": productDTOs])
    }

    func addProductViewHandler(req: Request) async throws -> View {
        return try await req.view.render("add")
    }

    func deleteProductViewHandler(req: Request) async throws -> View {
        let products = try await Product.query(on: req.db).all()
        let productDTOs = products.map { $0.toDTO() }
        return try await req.view.render("delete", ["products": productDTOs])
    }
}
