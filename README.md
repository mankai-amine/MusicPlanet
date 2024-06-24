# MusicPlanet

MusicPlanet is an application that will help connect you with new music, and also help you bond with your friends over similar tastes!
Using our app you can:

1. Set up favorites list and share it with others
2. When liking a track, see which users also liked it
3. Find other tracks and albums by an artist
4. Find biographies about your artists
5. Find tracks based of the track name or album
6. Find albums based on album name or artist

## Development

* Server API Documentation: [API Documentation](https://documenter.getpostman.com/view/3159462/2sA3XWce9j)

### Configure Environment Variables

Create a `.env` file in the root of the project and add the following environment variables:

```properties
MYSQL_HOST=localhost
MYSQL_PORT=3306
MYSQL_DB=musicplanet
MYSQL_USER=musicplanet
MYSQL_PASSWORD=you_db_password
PORT=8000
```
The variables are used to configure `application.properties` file.

### schema.sql

The `schema.sql` file is used to create the database schema. The file is located in the `src/main/data` directory.

Each line in the file is a SQL statement, and the file is executed when the application starts. **Don't** split the SQL statements into multiple lines.

## References

* [dotenv-java](https://github.com/cdimascio/dotenv-java) - Use dotenv in project management environment variables. Put a .env file in the root of the project and add the environment variables to it.