const posts = [
    {
        id: 1,
        title: 'Introduction to JavaScript',
        author: 'Alice Johnson',
        content: 'JavaScript is a versatile programming language used primarily for web development.',
    },

    {
        id: 2,
        title: 'React Basics',
        author: 'Bob Smith',
        content: 'React is a popular JavaScript library for building user interfaces, particularly for single-page applications.',
    },

    {
        id: 3,
        title: 'Understanding Redux',
        author: 'Catherine Lee',
        content: 'Redux is a state management library commonly used with React to manage application state in a predictable way.',
    },
    {
        id: 4,
        title: 'Advanced Node.js',
        author: 'Daniel Kim',
        content: 'Node.js allows for server-side scripting with JavaScript, enabling developers to create dynamic web applications.',
    },
]

export default class Post {
    constructor(id, title, author, content) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
    }

    static findAll() {
        return structuredClone(posts);
    }

    static findById(id) {
        return posts.find(post => post.id === id);
    }

    static updateById(id, post){
        const checkingPost = Post.findById(id);
        checkingPost.content = post.content;
        checkingPost.title = post.title;
        checkingPost.author = post.author;
    }
}