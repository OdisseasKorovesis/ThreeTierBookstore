$(document).ready(function () {   
    var book;
    var paramName = "id";        
    $.ajax({
        url: "tier3/books/" + decodeURIComponent(getBookIdFromUrl(paramName)),
        data: {
            format: 'json'
        },
        error: function() {
            alert("Could not find this book!");
        },
        success: function (data) {
            book = data;
            generateBookInfo(book);
        }
    });
});

function getBookIdFromUrl(paramName) {    
    var results = new RegExp('[\?&]' + paramName + '=([^&#]*)').exec(window.location.href);
	return results[1] || 0;
}

function generateBookInfo(book) {    
    $('#bookTitle').text(book.title);
    $('#bookImage').attr('src', book.imageUrl); 
    $('#authorName').text(book.authorsCollection[0].firstName + " " + book.authorsCollection[0].lastName);     
    $('#bookPrice').text("Price: " + (book.price / 100) + "$");
    $('#bookAvailability').text(convertStockLevelToMessage(book));  
    $('#bookDescription').text(book.description);
    $('#bookOriginalTitle').text("Original Title: " + book.originalTitle);
    $('#bookPages').text("Number of Pages: " + book.nrOfPages);
    $('#bookPublisher').text("Publisher: " + book.publisherId.name);
    $('#bookISBN').text("ISBN: " + book.isbn);
    $('#bookYear').text("Publication Year: " + book.publicationYear);
    $('#bookGenre').text("Genre: " + book.genreId.name);      
}

function convertStockLevelToMessage(book) {
    var booksRemaining = book.inventory.stockLevel;
    var availabilityMessage;
    if(booksRemaining < 10) {
        availabilityMessage = "Only a few copies left!";
    } else {
        availabilityMessage = "Readily available"
    }
    return availabilityMessage;
}

