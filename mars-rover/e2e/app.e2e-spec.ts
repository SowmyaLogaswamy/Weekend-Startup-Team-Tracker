import { MarsRoverPage } from './app.po';

describe('mars-rover App', () => {
  let page: MarsRoverPage;

  beforeEach(() => {
    page = new MarsRoverPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
