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

    if (res.status === 401) {
      throw new Error('Unauthorized');
    } else if (res.status === 403) {
      throw new Error('Forbidden');
    }

    return {
      status: res.status,
      json: await res.json()
    };
  }
}
