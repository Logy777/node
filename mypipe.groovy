pipeline {
  environment {
    registry = "logy777/node"
    // registryCredential = 'dockerhub'
  }
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
    stage('Remove Unused docker image') {
      steps{
        sh "docker run -p 8091:3000 --rm -d $registry:$BUILD_NUMBER"
      }
    }
    // stage('Remove Unused docker image') {
    //   steps{
    //     sh "docker rmi $registry:$BUILD_NUMBER"
    //   }
    // }    
  }
}