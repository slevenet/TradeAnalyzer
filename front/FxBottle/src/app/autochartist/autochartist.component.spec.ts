import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AutochartistComponent } from './autochartist.component';

describe('AutochartistComponent', () => {
  let component: AutochartistComponent;
  let fixture: ComponentFixture<AutochartistComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AutochartistComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AutochartistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
