import axios from "axios";

const base_url = process.env.REACT_APP_API_URL;
const token = process.env.REACT_APP_TOKEN;

class ApiService{
    constructor(){
        this.client = axios.create({
            baseURL: base_url,
            timeout: 10000,
            headers: {
                'Content-Type': 'application/json',
                'Bearer': token,
            }
        });
    }

    async getAllPost(){
        try {
            const response = await this.client.get('/posts');
            return response.data;
          } catch (error) {
            console.error("Error fetching data:", error);
            throw error;
          }
    }

    async getPostbyId(id){
        try {
            const response = await this.client.get(`/posts/${id}`);
            return response.data;
          } catch (error) {
            console.error("Error fetching data:", error);
            throw error;
          }
    }

    async deletePostbyId(id){
        try {
            const response = await this.client.delete(`/posts/${id}`);
            return response.data;
          } catch (error) {
            console.error("Error fetching data:", error);
            throw error;
          }
    }

    async addPost(post){
        try {
            const response = await this.client.post('/posts', post);
            return response.data;
          } catch (error) {
            console.error("Error fetching data:", error);
            throw error;
          }
    }

    async addComment(postId, comment){
        try {
            const response = await this.client.post(`/posts/${postId}/comments`, comment);
            return response.data;
          } catch (error) {
            console.error("Error fetching data:", error);
            throw error;
          }
    }

   
}

export default  new ApiService();