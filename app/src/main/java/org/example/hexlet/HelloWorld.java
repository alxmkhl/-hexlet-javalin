package org.example.hexlet;

import io.javalin.Javalin;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        app.get("/users", ctx -> ctx.result("GET /users"));
        app.post("/users", ctx -> ctx.result("POST /users"));
        app.get("/hello", ctx -> {
            var name = ctx.queryParam("name");
            ctx.result("Hello " + name + "!");

        });
        app.get("/users/{id}/post/{postId}", ctx -> {
            ctx.result("ID: " + ctx.pathParam("id"));
            ctx.result("Post ID: " + ctx.pathParam("postId"));
        });
        app.start(7070);
    }
}