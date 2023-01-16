resource "aws_instance" "MyInstance" {
  ami           = "ami-0f69bc5520884278e"
  instance_type = "t2.micro"
  key_name      = "Mypemfile"
  security_groups = ["sg-0ffb58db1648fe3a1"]
  
  tags = {
    Name = "Terraform_Docker"
  }
}
