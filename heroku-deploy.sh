#!/usr/bin/env bash

# Assign default deployment directory
DEPLOYMENT_DIRECTORY=./ready-for-deployment

# Get app name from positional parameter (this will be the name you gave your app when you created it on Heroku)
APP_NAME=$1

# Get the war name from positional parameter (When you start versioning WARs, the name should be the most recent
WAR_NAME=$2

# Build your war from the root directory
mvn clean install

# Make sure /ready-for-deploy exists

if [ ! -d "${DEPLOYMENT_DIRECTORY}" ]; then
  mkdir ready-for-deployment
fi

# If WAR_NAME isn't provided, set it with default
if [ -z "${WAR_NAME}" ]
then
    echo "[WARNING]: WAR name not provided. Using default"
    WAR_NAME=solution-0.0.1-SNAPSHOT.war
    echo ${WAR_NAME}
fi


# Copy the built war from the /target directory to /ready-for-deploy
cp ./target/${WAR_NAME} ${DEPLOYMENT_DIRECTORY}


# Ensure the Heroku CLI Deploy plugin is installed
heroku plugins:install heroku-cli-deploy

# Deploy to Heroku! 👌
heroku war:deploy ${DEPLOYMENT_DIRECTORY}/${WAR_NAME} --app ${APP_NAME}

# Now, check if it's deployed properly!
ACCOUNTS=$(curl https://${APP_NAME}.herokuapp.com/rest/accounts)

# Echo the accounts to terminal
echo ${ACCOUNTS}