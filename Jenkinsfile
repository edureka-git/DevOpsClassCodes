pipeline { 
    agent any
    environment {
    JAVA_HOME= tool name: 'java', type: 'jdk'
}   
   
    stages { 
        stage('Compile') { 
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
