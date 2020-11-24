function getBooks() {
    return [
        {   
            id: 1, 
            genre: 'Fiction', 
            name: 'Kitsune', 
            author: 'Andrei Belyayev', 
            year: 2020, 
            language: 'Russian',
            cover: 'http://loveread.ec/img/photo_books/90227.jpg', 
            description: 'Кицунэ – это лиса-оборотень из Японии. Отличается красотой, хозяйственностью и чистоплотностью, умеет петь, танцевать, готовить, наводить порядок в квартире, читать стихи, нравится маме. В остальное время – машет самурайским мечом, убивает нечисть, калечит местный криминал, строит бесов, питается чаем или чёрными сердцами злых людей. В целом просто ми-ми-ми!P.S. Ровно до тех пор, пока она не поселилась в вашем доме…',
            tags: [
                {tag: 'fiction'}, 
                {tag: '2020'}, 
                {tag: 'kitsune'}
            ]
        },
        {   
            id: 2, 
            genre: 'Fiction', 
            name: 'Escape from Tarkov', 
            author: 'Alexandr Kontorovich', 
            year: 2020, 
            language: 'Russian',
            cover: 'http://loveread.ec/img/photo_books/90226.jpg', 
            description: 'Tретья книга серии По мотивам игры «Побег из Таркова».',
            tags: [
                {tag: 'fiction'},{tag: '2020'},{tag: 'russian'}
            ]
        }
    ]
}

export default getBooks;