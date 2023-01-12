resource "aws_instance" "MyInstance" {
  ami           = "ami-0f69bc5520884278e"
  instance_type = "t2.micro"
  key_name      = "Mypemfile"
  
  tags = {
    Name = "Terraform_Docker"
  }
}
