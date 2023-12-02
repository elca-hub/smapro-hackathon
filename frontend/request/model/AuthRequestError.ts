export default class AuthRequestError extends Error {
    constructor(message: string) {
        super(message);
        this.name = 'AuthRequestError';
    }
}
