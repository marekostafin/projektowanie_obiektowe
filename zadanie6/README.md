# Zadanie 6

### Na 3.0

Pliki zadania 6 umieściłem w osobnym repozytorium, ponieważ w ten sposób łatwiej było mi skonfigurować hook'a.
Pliki znajdują się tutaj:

https://github.com/marekostafin/po-zadanie6

Hook, który dodałem ma następujący kod.
```
#!/bin/bash

STAGED_FILES=$(git diff --cached --name-only --diff-filter=ACM | grep ".jsx\{0,1\}$")

PASS=true

for FILE in $STAGED_FILES
do
  npx eslint "$FILE"

  if [[ "$?" == 0 ]]; then
    echo "ESLint Passed: $FILE"
  else
    echo "ESLint Failed: $FILE"
    PASS=false
  fi
done

echo "\nJavascript validation completed!\n"

if ! $PASS; then
    echo "ESLint found errors. Please fix them before committing."
    exit 1
fi
```
Nagranie ilustrujące jego działanie znajduje się w katalogu z niniejszym README.
