pipeline { 
    agent any
    env.JAVA_HOME= tool name: 'java', type: 'jdk'
    
    def mvnHome= tool name: 'maven', type: 'maven'

    def mvnCMD= "${mvnHome}/bin/mvn" 
    stages { 
        stage('Compile') { 
            steps { 
               echo "Compiling the code."
                sh "${mvnCMD} compile" 
            }
}
     stage('package') {
         echo "packaging the code"
         sh "${mvnCMD} package"       
}

    }
}
