pipeline {
  agent any

  options {
    disableConcurrentBuilds()
    buildDiscarder(logRotator(numToKeepStr:'5'))
  }


  environment {
    registry = "pichayutpee/test"
    DB_USER="siisa"
    DB_PASSWORD="password"
    DB_HOST="TSBSSQ05"
    DB_PORT="1433"
    DB_DATABASE="CPFSAP_SCRAP"
    LOG_PATH='build/log/'
  }

  stages {

    stage('Cleanup before build') {
      steps {
        cleanWs()
      }
    }

    stage('Checkout from Git') {
      steps {
        checkout scm
      }
    }

    stage('Compile') {
      steps {
        sh "./gradlew bootJar"
      }
    }

    stage('Unit test') {
      steps {
        sh "./gradlew test"
      }
    }

    stage('Buid Docker Img') {
        steps {
            script {
             sh "docker build -t ascendcorp/ptvn-cpf-op-contract-api:1.0.0.${BUILD_NUMBER} ."
             }
           }
       }
       
     stage("Dockerhub login") {
          steps {
            withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'DockerHub_Pichayut',
                              usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
              sh "docker login --username $USERNAME --password $PASSWORD"
            }
          }
        }

    stage('Push Image to Dockerhub') {
         steps {
            sh "docker push ascendcorp/ptvn-cpf-op-contract-api:1.0.0.${BUILD_NUMBER}"
          }
        }
      }

}