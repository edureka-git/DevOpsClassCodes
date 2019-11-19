pipeline { 
    agent any
    options {
        disableConcurrentBuilds() 
    buildDiscarder(logRotator(numToKeepStr: '30', artifactNumToKeepStr: '30'))
  }
    environment {
    JAVA_HOME= tool name: 'java', type: 'jdk'
    def mvnHome= tool name: 'maven', type: 'maven'
    def mvnCMD= "${mvnHome}/bin/mvn"
}   
   
    stages { 
        stage('Compile') { 
            options {
            timeout(time: 1, unit: 'SECONDS')
            }
            steps { 
                echo "Compiling the code."
                sh "${mvnCMD} compile" 
                
            }
}
        
     stage('package') {
         steps{
         echo "packaging the code"
         sh "${mvnCMD} package"       
}
     }

    }
}
