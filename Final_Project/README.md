# Final Project
## CodePipeline

Build a CI/CD Pipeline to deploy a static website from GitHub to an S3 Bucket

Setup:
IAM Role: AWSCodePipelineServiceRole-us-east-1-rmf-static-cicd-demo-pipel
IAM Group: CodeDeploy
		   AWSCodeDeployFullAccess


Bucket
1) Create Bucket: rmf-cicd-demo
2) Disable "Block all public access"
3) Create Bucket
4) Edit Bucket Properties:
	- Enable "Static website hosting"
5) Edit Bucket Permissions:
	- Bucket Policy
	```
	{
	    "Version": "2012-10-17",
	    "Statement": [
	        {
	            "Sid": "PublicReadGetObject",
	            "Effect": "Allow",
	            "Principal": "*",
	            "Action": "s3:GetObject",
	            "Resource": "arn:aws:s3:::rmf-cicd-demo/*"
	        }
	    ]
	}
	```

Pipeline
6) Create Pipeline: rmf-cicd-demo-pipeline
7) Create "New Service Role" (or use existing)
If creating new: Ensure "Allow AWS CodePipeline to create a service role so it can be used with this new pipeline" is checked
8) Source Provider: GitHub (Version 2)
9) Connect to GitHub
10) Select Repo (demo-bucket) / Branch (Master)
11) Output Artifact: CodePipeline Default
12) Skip Build Provider (Static site)
13) Deploy provider: S3
14) Bucket: rmf-cicd-demo
15) Select "Extract file before deploy"







