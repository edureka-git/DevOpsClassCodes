pipeline{
    
    tools{
        
        jdk "myjava"
        maven "mymaven"
        
    }
    agent none
        stages{
            stage('Checkout'){
                agent any
                steps{
                    git "https://github.com/edureka-git/DevOpsClassCodes.git"
                    
                }
            }
            stage('Compile'){
                agent any
                steps{
                    sh "mvn compile"
                }
            }
            stage('metriccheck'){
                agent any
                steps{
                    sh "mvn cobertura:cobertura -Dcobertura.report.format=xml"
                    
                }
            }
            stage('package'){
                agent any
                steps{
                    sh "mvn package"
                }
            }
            
            
            
        }   
    }
