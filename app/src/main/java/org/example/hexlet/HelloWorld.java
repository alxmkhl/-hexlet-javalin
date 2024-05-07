package org.example.hexlet;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;
import io.javalin.rendering.template.JavalinJte;
import org.example.hexlet.dto.courses.CoursePage;
import org.example.hexlet.dto.courses.CoursesPage;
import org.example.hexlet.model.Course;
import org.example.hexlet.utils.FakeCourses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.javalin.rendering.template.TemplateUtil.model;

public class HelloWorld {
    public static void main(String[] args) {
        // Создаем приложение


        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        app.get("/", ctx -> ctx.render("index.jte"));
        app.get("/courses", ctx -> {
            var term = ctx.queryParam("term");
            List<Course> courseList = new ArrayList<>();
            if (term == null) {
                courseList = FakeCourses.getCourseList();
            } else {
                courseList = FakeCourses.getCourseList().
                        stream().
                        filter(course -> course.getName().toLowerCase().contains(term.toLowerCase()))
                        .collect(Collectors.toList());
            }
            var page = new CoursesPage(courseList, "Courses", term);
            ctx.render("courses/index.jte", model("page", page));
        });

        app.get("/courses/{id}", ctx -> {
            var id = ctx.pathParam("id");
            var course = FakeCourses.getCourseList().stream()
                    .filter(c -> c.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new NotFoundResponse("Course with id " + id + " not found"));
            ctx.render("courses/course.jte", model("page", new CoursePage(course)));
        });

        app.start(7070);
    }
}