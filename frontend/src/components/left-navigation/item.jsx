import React from 'react';
import './item.css';

function Item(genre) {
    
    return(
        <div className='item'>
            <a href='#'>{genre.name}</a>
        </div>
    );
}

export default Item;

