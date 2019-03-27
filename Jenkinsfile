pipeline {
         agent any
         stages {
                 stage('One') {
                 steps {
                     echo 'Hi, this is Zulaikha from edureka'
                 }
                 }
                  stages {
                 stage('ten') {
                 steps {
                     echo 'Hi, this is Neeraj from RSystems'
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
                 }
         }
}
