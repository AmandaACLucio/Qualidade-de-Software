import axios from 'axios';

import { IMidiaGo } from '@/shared/model/midia-go.model';

const baseApiUrl = 'api/midia-gos';

export default class MidiaGoService {
  public find(id: number): Promise<IMidiaGo> {
    return new Promise<IMidiaGo>((resolve, reject) => {
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
}
