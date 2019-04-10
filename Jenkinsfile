pipeline { 
    agent any
    environment {
    JAVA_HOME= tool name: 'java', type: 'jdk'
}   
   
    stages { 
        stage('Compile') { 
            steps { 
                echo "Compiling the code."
                def mvnCMD= "${mvnHome}/bin/mvn"
                sh "${mvnCMD} compile" 
                
            }
}
     stage('package') {
         echo "packaging the code"
         def mvnCMD= "${mvnHome}/bin/mvn"
         sh "${mvnCMD} package"       
}

    }
}
