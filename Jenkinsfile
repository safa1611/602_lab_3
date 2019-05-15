node('linux') {

        stage('Create Test Stack') {
          
             git credentialsId: 'c30bcf6b-d65c-4439-9c52-735a47eea2ea', url: 'https://github.com/safa1611/602_lab_3.git'
             withCredentials([[$class: 'AmazonWebServicesCredentialsBinding', accessKeyVariable: 'AWS_ACCESS_KEY_ID', credentialsId: '633ca12c-f866-45d4-9173-1fd27644f88b', secretKeyVariable: 'AWS_SECRET_ACCESS_KEY']]) {
                   sh 'aws cloudformation create-stack --stack-name test2 --region us-east-1 --template-url https://s3.amazonaws.com/safa1611-assignment-4/docker-single-server.json --parameters ParameterKey=KeyName,ParameterValue=SEIS665-03-SpringSem2019-VA ParameterKey=YourIp,ParameterValue=$(curl ifconfig.me)/32'
                   sh 'aws cloudformation wait stack-create-complete --stack-name test2 --region us-east-1' 
                   sh 'aws cloudformation describe-stacks --stack-name test2 --region us-east-1'
                   env.docker1IP = sh returnStdout: true, script: 'aws cloudformation describe-stacks --stack-name test2 --region us-east-1 --query Stacks[].Outputs[].[OutputValue] --output text'
                   sshagent(['d5e36dc1-bb07-445a-8aa2-5ef88ba08181']) {
                   sh 'ssh -o StrictHostKeyChecking=no ubuntu@${docker1IP} uptime'
                   }
             }
        }
}
             
