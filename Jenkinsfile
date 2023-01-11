pipeline {
    agent any
    
    tools {
        maven 'M2_HOME'
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
                sh 'docker build -t devopscbabu/DevOpsAddressBook .
            }
        }
        stage('Docker Push') {
            steps { 
                withCredentials([string(credentialId: 'cbabu85', password: "xxxxxxxx')]) {
                sh 'docker login -u cbabu85 -p ${xxxxxxxx}'
                  }
                sh 'docker push devopscbabu/DevOpsAddressBook'
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
