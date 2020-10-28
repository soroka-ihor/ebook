import React from 'react';
import Item from './item.jsx';
import './Genre.css';

function Genres(props) {

    const genres = props.genres;
    
    const genreItems = genres.map((genre) => 
        <li key={genre.toString()}>
            <Item id={genre.id} name={genre.name}/>
        </li>
    );

    return(
        <nav className="genres">
          <ul>{genreItems}</ul>
        </nav>
    );
}

export default Genres;