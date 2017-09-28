#!/bin/sh

if git status -s | grep README.md; then
    git checkout master
    git config user.email "travis@travis.com"
    git config user.name "travis"
    git add -u
    git commit -m "Update README.md"
    git push -fq "https://${GH_TOKEN}@github.com/NomadBlacky/scala_samples.git" master:master
    echo "OK: git push"
fi