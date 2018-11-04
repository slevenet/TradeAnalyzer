import { TestBed } from '@angular/core/testing';

import { AutochatistService } from './autochatist.service';

describe('AutochatistService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AutochatistService = TestBed.get(AutochatistService);
    expect(service).toBeTruthy();
  });
});
