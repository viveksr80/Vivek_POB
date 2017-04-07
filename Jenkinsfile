pipeline {
  agent any
  stages {
    stage('App_Build_ST') {
      steps {
        echo 'Building...'
      }
    }
    stage('Unit_Tests_ST') {
      steps {
        echo 'Testing...'
            }
    }
    stage('Code_Analysis_ST') {
      steps {
        echo 'Deploying....'
      }
    }
	stage('Deploy_Environment_ST') {
      steps {
        echo 'Deploying....'
      }
    }
	stage('Test_Build_ST') {
      steps {
        echo 'Deploying....'
      }
    }
    stage('Continuous_Testing_ST') {
      steps {
        parallel(
          "01-Functional_Tests_ST": {
            bat 'echo %time%'
            
          },
          "02-BDD_Regression_Tests_ST": {
            bat 'echo %time%'
            
          },
          "03-Platform_Tests_ST": {
            bat 'echo %time%'
            
          },
          "04-API_Tests_ST": {
            bat 'echo %time%'
            
          }
        )
      }
    }
    stage('Pre_Prod_Deploy') {
      steps {
        echo 'SIT Deploying...'
      }
    }
  }
}