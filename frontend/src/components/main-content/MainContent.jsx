import React from 'react';
import Book from './book/Book.jsx';
import './MainContent.css';

function MainContent(props) {

    const booksArray = props.books;
    const singlebook = booksArray.map((book) =>
        <Book id={book.id} 
              name={book.name}
              genre={book.genre}
              author={book.author} 
              year={book.year} 
              description={book.description}
              cover={book.cover}
        />
    )

    return(
        <div className="main-content">
          main content
          {singlebook}
        </div>
    );
}

export default MainContent;