import AuthRequestError from "./model/AuthRequestError";
import AuthResponse from "./model/AuthResponse";
import AuthToken from "./model/AuthToken";

type Method = 'GET' | 'POST' | 'PUT' | 'DELETE';

export default class AuthRequest {
  private readonly apiEndpoint = 'http://localhost:5050/';

  private token: AuthToken;

  constructor(token: AuthToken) {
    this.token = token;
  }

  async request(path: string, method: Method, body?: any): Promise<AuthResponse> {
    const headers = {
      'Content-Type': 'application/json',
      'Authorization': `${this.token.getToken()}`
    };

    const res = await fetch(`${this.apiEndpoint}${path}`, {
      method,
      headers,
      body: JSON.stringify(body)
    });

    switch (res.status) {
      case 401:
        throw new AuthRequestError('Unauthorized');
      case 403:
        throw new AuthRequestError('Forbidden');
      case 500:
        throw new AuthRequestError('Internal Server Error');
      default:
        window.location.href = '/signin';
    }

    return {
      status: res.status,
      json: await res.json()
    };
  }
}
