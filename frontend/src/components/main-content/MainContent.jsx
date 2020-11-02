import React from 'react';
import Book from './book/Book.jsx';
import './MainContent.css';

function MainContent(props) {

    const books = props.books;

    return(
        <div className="main-content">
          main content
          <Book />
          <Book />
          <Book />
        </div>
    );
}

export default MainContent;