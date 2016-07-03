#!groovy

stage "Build"
node {
    echo "Build"
    git url:"https://github.com/devkiela/mailings.git"
}

stage "Integration tests, webtests and Sonar"
parallel(
   Integrationtests: {
       node {
           echo "Integration tests"
       }
   },
   Webtests: {
       node {
           echo "Webtests"
       }
   },
   Sonar: {
       node {
           echo "Sonar"
       }
   }
)

stage "Deploy to staging"
node {
    echo "Deploy to staging"
}

stage "Deploy to production"
node {
    echo "Deploy to production"
}