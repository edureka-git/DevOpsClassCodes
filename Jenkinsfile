node {
    env.JAVA_HOME= tool name: 'java', type: 'jdk'
    def mvnHome= tool name: 'maven', type: 'maven'
    def mvnCMD= "${mvnHome}/bin/mvn"
    stage('checkout'){
        
        git 'https://github.com/neeraj14apr/DevOpsClassCodes.git'
         
    }
    stage('compile'){
        script{
            echo "compiling the code"
            sh "${mvnCMD} compile"
        }
    }
    stage('package'){
        script{
            echo "package the code"
            sh "${mvnCMD} package"
        }
        }
 
    }
