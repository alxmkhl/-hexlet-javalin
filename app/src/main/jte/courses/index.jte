@import org.example.hexlet.dto.courses.CoursesPage
@param CoursesPage page

@template.layout.page(
content = @`
    <form action="/courses" method="get">
        <div class="row g-3">
            <div class="col">
                <input type="search" class="form-control" placeholder="course name" aria-label="First name" required name="term">
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary">Find course</button>
            </div>
        </div>
    </form>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Course name</th>
            <th scope="col">Course description</th>
        </tr>
        </thead>
        @for(var course : page.getCourses())
            <tbody>
            <tr>
                <th scope="row">${course.getId()}</th>
                <td>${course.getName()}</td>
                <td>@${course.getDescription()}</td>
            </tr>
            </tbody>
        @endfor
    </table>
`
)
