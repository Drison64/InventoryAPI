#!/bin/sh -l

git clone https://github.com/Drison64/InventoryAPI
cd InventoryAPI

mvn install

# Install to github .m2
mkdir -p .m2/repository
echo "Copying from /root/.m2/repository to $PWD/.m2/repository"
cp -a /root/.m2/repository/. .m2/repository