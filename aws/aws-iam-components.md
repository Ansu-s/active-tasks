# AWS Identity & Access Management (IAM) Components

## Users

- IAM has a Root User Account. The root user has all the permissions.
- User accounts can be created and when created they don't have any permissions associated with them by default.
- A single user can be a member of upto 10 groups.
- A user has two names such as a Friendly name (John, Ram... not unique) and ARN (Amazon Resource Name) it is a unique identifier cross accounts.
- Login in to a user account can be done using the management console, the CLI and the API.
- Authentication to user accounts in the management console is done using the username and password and for the CLI and API access keys are used.

## Roles

- Role is an identity that has specific permissions.
- Policies are added to roles to give permissions, these roles are assumed by users, applications and services. Once assumed the identity becomes the role and gains its privileges.
- Roles have trust policies and permissions policies associated with them.
- Roles can be used for tasks like granting temporary access to aws resources, cross-account-access, giving access to aws services like EC2 instance of S3 bucket, these can also perform task on behalf of users.

## Groups

- A group can contain a user or a number of users.
- We can add policies to the group, which makes all the users in the group inherit the added policy.
- A user gains permissions applied to the group through the policy, this is known as identity based policy since the policy is applied to an identity (a user is an identity).
- Identity-based policies can be applied to users, groups and roles.
- We can have a number of groups such as admin group, development group, operations group etc. thus helping organize users.

## Policies 

- Policies are documents that define permissions and these are written in JSON.
- These are of multiple types such as Identity-based policies (applied to Users,Groups and Roles) and Resource-Based policies(applied to S3 bucket or DynamoDb)
- All permissions are implicit by default, we write statements in json to allow access to specific actions. 
- policies define permission for the identities and resources they are associated with
- A user gains permissions to resources by a policy
  - Identity-based policy - these are attached to Users, Groups or Roles
  - Resource-based policy - these are attached to a resource and define the permissions for the principal accessing the resource.
  - IAM permissions boundaries - sets the maximum permissions an Identity-based policy can grant to an IAM entity.
  - AWS Organisations Service Control Policies (SCP) - Specifies the maximum permissions for an organisation or Organizational Unit.
```
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Effect": "Allow",
      "Action": "ec2:StartInstances",
      "Resource": "*"
    }
  ]
}
```
### Policy Determination Rules  

![image](https://github.com/user-attachments/assets/d95af7a8-4d8c-4664-87fa-a49ec357837a)  

- By default, all the requests are implicitly denied except for the root user.
- An explicit allow in identity-based or resource-based policy overrides this default.
- If a permissions' boundary, Organisation SCP or session policy is present this can override the above allow with an implicit deny.
- An explicit deny in any policy overrides any allows.
