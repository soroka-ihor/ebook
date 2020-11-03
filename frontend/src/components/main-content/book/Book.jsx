import React from 'react';
import './book.css';

function Book(book) {
    return(
        <div className="book">
            <div className="book-header">
                <div className="name">
                    {book.name}
                </div>
                <div className="genre">
                    {book.genre}
                </div>
            </div>
            <div className="book-cover">
                <img src={book.cover}/>
            </div>
            <div className="book-description">
                 <div className="author">{book.author}</div>
                 <div className="name">{book.name}</div>
                 <div className="year">{book.year}</div>
                 <div className="language">{book.language}</div>
                 <div className="desc">{book.description}</div>
            </div>
        </div>
    );
}

export default Book;