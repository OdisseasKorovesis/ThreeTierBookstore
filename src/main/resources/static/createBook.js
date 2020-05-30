$(document).ready(function () {
    $("#bookForm").on('submit', function (event) {
        console.log("pressed");
        event.preventDefault();
        var formData = {};
        $("#bookForm").find(":input").each(function () {
            formData[this.name] = $(this).val()
        })
        console.log(JSON.stringify(formData));
        $.ajax({
            type: "POST",
            url: "tier3/books",
            data: (JSON.stringify(formData)),
            dataType: "json",
            contentType: "application/json;",
            statusCode: {
                201: function () {
                    alert("Book create successfully");                    
                }
            },
            error: function() {
                alert("Could not create book please try again!");
            }
                
            
        });
    });
});

$(document).ready(function createGenreSelect() {
    var allGenre;
    $.ajax({
        url: "tier3/genre",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any genre!");
        },
        success: function (data) {
            allGenre = data;
            generateGenreSelect(allGenre);
        }
    });
});

$(document).ready(function createLanguageSelect() {
    var allLanguages;
    $.ajax({
        url: "tier3/languages",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any languages!");
        },
        success: function (data) {
            allLanguages = data;
            generateLanguageSelect(allLanguages);
        }
    });
});

$(document).ready(function createPublisherSelect() {
    var allPublishers;
    $.ajax({
        url: "tier3/publishers",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any publishers!");
        },
        success: function (data) {
            allPublishers = data;
            generatePublisherSelect(allPublishers);
        }
    });
});

$(document).ready(function createAuthorSelect() {
    var allAuthors;
    $.ajax({
        url: "tier3/authors",
        data: {
            format: 'json'
        },
        error: function () {
            alert("Could not find any authors!");
        },
        success: function (data) {
            allAuthors = data;
            generateAuthorSelect(allAuthors);
        }
    });
});

function generateGenreSelect(allGenre) {
    for (var i = 0; i < allGenre.length; i++)
        $('#bookGenre').append(
            "<option value= " + allGenre[i].id + ">" + allGenre[i].name + "</option>"
        )
}

function generateLanguageSelect(allLanguages) {
    for (var i = 0; i < allLanguages.length; i++)
        $('#bookLanguage').append(
            "<option value= " + allLanguages[i].id + ">" + allLanguages[i].name + "</option>"
        )
}

function generatePublisherSelect(allPublishers) {
    for (var i = 0; i < allPublishers.length; i++)
        $('#bookPublisher').append(
            "<option value= " + allPublishers[i].id + ">" + allPublishers[i].name + "</option>"
        )
}

function generateAuthorSelect(allAuthors) {
    for (var i = 0; i < allAuthors.length; i++)
        $('#bookAuthor').append(
            "<option value= " + allAuthors[i].id + ">"
            + allAuthors[i].firstName + " " + allAuthors[i].lastName + "</option>"
        )
}