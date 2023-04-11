@Library('Sizamtek_Sharedlibs') _
pipeline{
 agent {
       label 'master' 
       }
       tools {
        maven "maven_3.9.1"
         }
         stages{
          stage('gitpull'){
            steps {
              sh "echo 'initiating git pull'"
              git 'https://github.com/Ifedinabba/fifth-demo-project.git'
             }
            }
             stage('Clean Build'){
              steps {
                build('Clean')
              }
           }
           stage('Compile Source Code'){
                  steps {
                    build('SonarQube Report')
         }
        }
        stage('Upload Artifact'){
                  steps {
                    common('Compile')
        }
        }
        stage('JUnit Test'){
            steps {
              build('Test')
       }
       }
        stage('Package'){
            steps {
              build('Package')
       }
       }
        //================================
        }// Stages Close
        }// Pipeline Close
