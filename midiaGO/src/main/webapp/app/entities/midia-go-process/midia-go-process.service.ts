import axios from 'axios';

import { IMidiaGoProcess } from '@/shared/model/midia-go-process.model';

const baseApiUrl = 'api/midia-go-processes';

export default class MidiaGoProcessService {
  public find(id: number): Promise<IMidiaGoProcess> {
    return new Promise<IMidiaGoProcess>((resolve, reject) => {
      axios
        .get(`${baseApiUrl}/${id}`)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public retrieve(): Promise<any> {
    return new Promise<any>((resolve, reject) => {
      axios
        .get(baseApiUrl)
        .then(res => {
          resolve(res);
        })
        .catch(err => {
          reject(err);
        });
    });
  }

  public create(entity: IMidiaGoProcess): Promise<IMidiaGoProcess> {
    return new Promise<IMidiaGoProcess>((resolve, reject) => {
      axios
        .post(`${baseApiUrl}`, entity)
        .then(res => {
          resolve(res.data);
        })
        .catch(err => {
          reject(err);
        });
    });
  }
}
