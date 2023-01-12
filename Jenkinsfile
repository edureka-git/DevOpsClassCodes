pipeline {
    agent any
    
    tools {
        maven 'M2_HOME'
        terraform 'Terraform-1.3.7'
    }

    stages {
        stage('Checkout') {
            steps {
            checkout([$class: 'GitSCM', branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/devopscbabu/DevOpsAddressBook.git']]])
            }
        }
        stage('Compile') {
            steps {
            sh 'mvn clean package'
            }
        }  
        stage('Docker Build') {
            steps {
                sh 'docker build -t cbabu85/devopsaddressbook .
            }
        }
        stage('Docker Push') {
            steps { 
                withCredentials([string(credentialsId: 'docker-hub', variable: 'dockerHubPwd')]) {
                sh 'docker login -u cbabu85 -p ${dockerHubPwd}'
                  }
                sh 'docker push cbabu85/devopsaddressbook'
                  }                                     
             }
         stage('Terraform init') {
             steps {
                 sh 'terraform init'
             }
         }
         stage('Terraform Apply') {
             steps {
                 sh 'terraform apply --auto-approve'
             }
         }
     }
}
