# smartclide-db-api

A RESTful API for accessing the SmartCLIDE database (MongoDB). The API exposes the following endpoints:

## /users (GET,POST,PUT,DELETE)

### Example POST Request

```url
/users
```

### Example Request body

```json
{
    "id": "628c87f6aa5a2857398a80a0",
    "email": "test@mail.com",
    "team_id": "628c87f6aa5a2857398a80d8"
}	
```

## /teams (GET,POST,PUT,DELETE)

### Example POST Request

```url
/teams
```

### Example Request body

```json
{
    "name": "Test team",
    "workflows": [],
    "services": [],
    "deployments": []
}	
```

## /ci_managers (GET,POST,PUT,DELETE)

### Example POST Request

```url
/ci_managers
```

### Example Request body

```json
{
    "user_id": "628c87f6aa5a2857398a80a0",
    "type": "jenkins",
    "url": "http://some_url",
    "username": "test_user",
    "token": "giuggff8ff7igfigfiugi..."
}	
```

## /deployment_platforms (GET,POST,PUT,DELETE)

### Example POST Request

```url
/deployment_platforms
```

### Example Request body

```json
{
    "user_id": "628c87f6aa5a2857398a80a0",
    "url": "http://some_url",
    "username": "test_user",
    "token": "giuggff8ff7igfigfiugi..."
}
```

## /service_registries (GET,POST,PUT,DELETE)

### Example POST Request

```url
/service_registries
```

### Example Request body

```json
{
    "user_id": "628c87f6aa5a2857398a80a0",
    "type": "github",
    "url": "http://some_url",
    "username": "test_user",
    "token": "dnsuibfifgyucgufgu..."
}
```

## /git_credentials (GET,POST,PUT,DELETE)

### Example POST Request

```url
/git_credentials
```

### Example Request body

```json
[
	{
	    "user_id": "628c87f6aa5a2857398a80a0",
	    "type": "github",
	    "url": "http://some_url",
	    "username": "test",
	    "token": "bcsuifgsiufgsfiuiu"
	}
]
```

## /services (GET,POST,PUT,DELETE)

### Example POST Request

```url
/services
```

### Example Request body

```json
{
    "name": "Test service",
    "user_id": "628c87f6aa5a2857398a80a0",
    "registry_id": "628c8dab80b42501489a85da",
    "git_credentials_id": "628c922780b42501489a85dd",
    "url": "http://test_url",
    "description": "A short service description..",
    "is_public": true,
    "licence": "test_licence",
    "framework": "java",
    "created": "2022-01-14T15:42:25.000+00:00",
    "updated": "2022-01-14T15:42:25.000+00:00"
}
```

## /workflows (GET,POST,PUT,DELETE)

### Example POST Request

```url
/workflows
```

### Example Request body

```json
{
    "name": "Test service",
    "user_id": "628c87f6aa5a2857398a80a0",
    "git_credentials_id": "628c922780b42501489a85dd",
    "url": "http://test_url",
    "description": "A short workflow description..",
    "is_public": true,
    "created": "2022-01-14T15:42:25.000+00:00",
    "updated": "2022-01-14T15:42:25.000+00:00"
}
```

## /deployments (GET,POST,PUT,DELETE)

### Example POST Request

```url
/deployments
```

### Example Request body

```json
{
    "name": "Test service",
    "user_id": "628c87f6aa5a2857398a80a0",
    "git_credentials_id": "628c922780b42501489a85dd",
    "url": "http://test_url",
    "workflow_id": "6283ac19189ff14b1516c11c",
    "service_id": "628c928d80b42501489a85de",
    "version": "$deployment_version",
    "state": "$deployment_state",
    "created": "2022-01-14T15:42:25.000+00:00",
    "updated": "2022-01-14T15:42:25.000+00:00"
}
```
