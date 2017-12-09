#!/bin/bash

set -e

if [ "$TRAVIS_PULL_REQUEST" == "true" ]
then
    exit 0
fi

# only do deployment, when travis detects a new tag
if [ ! -z "$TRAVIS_TAG" ]
then
    echo "on a tag -> set pom.xml <version> to $TRAVIS_TAG"
    mvn --settings .travis/settings.xml org.codehaus.mojo:versions-maven-plugin:2.3:set -DnewVersion=$TRAVIS_TAG -Possrh

    if [ ! -z "$TRAVIS" -a -f "$HOME/.gnupg" ]; then
        shred -v ~/.gnupg/*
        rm -rf ~/.gnupg
    fi

    mvn clean deploy --settings .travis/settings.xml -DskipTests=true --batch-mode --update-snapshots -Possrh


    if [ ! -z "$TRAVIS" ]; then
        shred -v ~/.gnupg/*
        rm -rf ~/.gnupg
    fi
else
    echo "not on a tag -> keep snapshot version in pom.xml"
    mvn clean deploy --settings .travis/settings.xml -DskipTests=true --batch-mode --update-snapshots -Possrh
fi
