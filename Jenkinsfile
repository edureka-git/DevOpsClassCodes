pipeline {
         agent any
         stages {
                 stage('One') {
                 steps {
                     echo 'Hi, this is Zulaikha from edureka'
                 }
                 }
                 stage('Two') {
                 steps {
                    input('Do you want to proceed?')
                 }
                 }
                 stage('Three') {
                 when {
                       not {
                            branch "master"
                       }
                 }
                          
                 steps {
                       echo "Hello"
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
         }
}
