pipeline {
  environment {
    registry = "logy777/node"
    // registryCredential = 'dockerhub'
  }
  // agent {label 'ruvds'}
  agent any
  stages {
    stage('Cloning Git') {
      steps {
        git url: 'https://github.com/Logy777/node.git', branch: 'ver1.0.0'
        
      }
    }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER" , "--network host ."
        }
      }
    }
    // stage('Deploy Image') {
    //   steps{
    //     script {
    //       docker.withRegistry( '', registryCredential ) {
    //         dockerImage.push()
    //       }
    //     }
    //   }
    // }
    stage('Stop old docker container') {
      steps{
        sh "docker stop first_deploy"
      }
    } 
    stage('Run new docker container') {
      steps{
        sh "docker run -p 8091:80 --rm -d --name first_deploy $registry:$BUILD_NUMBER"
      }
    }
   
  }
}
