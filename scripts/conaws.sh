#!/bin/sh

# Make Terminal
# ssh -L [로컬포트]:[내부서버아이피]:[내부서버포트] -N -f -i [배스천서버인증서.pem] [배스천서버계정]@[배스천서버아이피]
ssh -L 55022:172.31.46.59:22 -N -f -i ~/.ssh/public.pem ec2-user@ec2-54-180-30-158.ap-northeast-2.compute.amazonaws.com

# Connect Internal(Security Zone) Server
# ssh -p [로컬포트] -i [내부서버인증서.pem] [내부서버계정]@127.0.0.1
ssh -p 55022 -i ~/.ssh/security.pem ec2-user@127.0.0.1
