pipeline { 
    agent any
    environment {
    JAVA_HOME= tool name: 'java', type: 'jdk'
    def mvnHome= tool name: 'maven', type: 'maven'
    def mvnCMD= "${mvnHome}/bin/mvn"
}   
   
    stages { 
        stage('Compile') { 
            steps { 
                echo "Compiling the code."
                echo "first step"
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
