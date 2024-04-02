#!/bin/bash
#Marek Ostafin 2024

BASE_URL="http://localhost:8000"

while getopts ":i:" opt; do
    case ${opt} in
        i )
            id=$OPTARG
            ;;
        \? )
            echo "Invalid option: $OPTARG" 1>&2
            ;;
        : )
            echo "Option -$OPTARG requires an argument." 1>&2
            ;;
    esac
done

shift $((OPTIND -1))


echo "List Products:"
curl -s -X GET "${BASE_URL}/product"
echo -e "\n"

echo "Add Product:"
curl -s -X POST -d "product[name]=New Product" -H "Content-Type: application/x-www-form-urlencoded" "${BASE_URL}/product/new"
echo -e "\n"

if [ ! -z "$id" ]; then
    echo "Update Product:"
    curl -s -X POST -d "product[name]=Updated Product" -H "Content-Type: application/x-www-form-urlencoded" "${BASE_URL}/product/${id}/edit"
    echo -e "\n"

    echo "Delete Product:"
    curl -s -X POST -d "_token=8374a33bf2c315cfd3454b52dfedfd91.39vWXp8VBg7XjjnPpBpEbmoeRfp9Vuor6yP0UKy45kQ.57qcbu8iWU_lt1Cs1V8lKQBUNpRLD6tbhUCsZpvWriDrkOEIrURkab_dbA" -H "Content-Type: application/x-www-form-urlencoded" "${BASE_URL}/product/${id}"
    echo -e "\n"
fi