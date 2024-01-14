pipeline {
    agent {
        label 'slave01'
    }
    
    tools {
        maven 'mymaven'
    }
    
    stages {
        stage('Clonerepo') {
            steps {
                git 'https://github.com/bhasker-manikyala/DevOpsClassCodes.git'
            }
        }
        stage('Compile') {
            steps {
                sh 'mvn compile'
            }
        }
        stage(CodeReview) {
            steps {
                sh 'mvn pmd:pmd'
            }
            post {
  success {
    recordIssues(tools: [pmdParser(pattern: '**/pmd.xml')])
  }
}
        }
        stage(UnitTesting){
            steps {
                sh 'mvn test'
            }
        }
        stage('Codecoverage'){
            steps {
               sh 'mvn verify'   
            }
        }
        stage('Package'){
            steps {
               sh 'mvn package'   
            }
        }
    }
}
